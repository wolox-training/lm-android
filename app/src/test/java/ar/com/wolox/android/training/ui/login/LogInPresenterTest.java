package ar.com.wolox.android.training.ui.login;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.LinkedList;
import java.util.List;

import ar.com.wolox.android.training.ui.network.entities.UserResponse;
import ar.com.wolox.android.training.ui.network.services.LogInService;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LogInPresenterTest {

    RetrofitServices mretrofitServicesMock;
    LogInService mlogInServiceMock;
    LogInView mLoginViewMock;
    LogInPresenter logInPresenter;

    @Before
    public void beforeTest(){
        mLoginViewMock = Mockito.mock(LogInView.class);
        mretrofitServicesMock = Mockito.mock(RetrofitServices.class);
        mlogInServiceMock = Mockito.mock(LogInService.class);

        Mockito.when(mretrofitServicesMock.getService(eq(LogInService.class))).thenReturn(mlogInServiceMock);
        logInPresenter = new LogInPresenter(mLoginViewMock, mretrofitServicesMock);
    }

    @Test
    public void reposForUserOnFailure(){
        // Given
        Call<List<UserResponse>> callMock = Mockito.mock(Call.class);
        Mockito.when(mlogInServiceMock.reposForUser(anyString())).thenReturn(callMock);
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Callback callback = invocation.getArgument(0);
                callback.onFailure(callMock, new Exception("Hola"));
                return null;
            }
        }).when(callMock).enqueue(any(Callback.class));

        // When
        logInPresenter.doLogin("mockemail", "123456789");

        // Then
        Mockito.verify(mLoginViewMock).onLoginFailed(eq("Check your Internet connection"));
    }

    @Test
    public void reposForUserWithEmailErrorResponse(){
        // Given
        List<UserResponse> users = new LinkedList<>();
        Response<List<UserResponse>> responseMock = Mockito.mock(Response.class);
        Mockito.when(responseMock.body()).thenReturn(users);

        Call<List<UserResponse>> callMock = Mockito.mock(Call.class);
        Mockito.when(mlogInServiceMock.reposForUser(anyString())).thenReturn(callMock);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Callback callback = invocation.getArgument(0);
                callback.onResponse(callMock, responseMock);
                return null;
            }
        }).when(callMock).enqueue(any(Callback.class));

        // When
        logInPresenter.doLogin("mockemail", "123456789");

        // Then
        Mockito.verify(mLoginViewMock).onLoginFailed(eq("No valid user name"));
    }

    @Test
    public void reposForUserWithPasswordResponse(){
        // Given
        List<UserResponse> users = new LinkedList<>();
        Response<List<UserResponse>> responseMock = Mockito.mock(Response.class);

        UserResponse userMock = new UserResponse();
        userMock.setEmail("mockuser");
        userMock.setPassword("123456789");
        users.add(0,userMock);


        Mockito.when(responseMock.body()).thenReturn(users);
        Call<List<UserResponse>> callMock = Mockito.mock(Call.class);
        Mockito.when(mlogInServiceMock.reposForUser(anyString())).thenReturn(callMock);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Callback callback = invocation.getArgument(0);
                callback.onResponse(callMock, responseMock);
                return null;
            }
        }).when(callMock).enqueue(any(Callback.class));

        // When
        logInPresenter.doLogin("mockemail", "asdasdasd");

        // Then
        Mockito.verify(mLoginViewMock).onLoginFailed(eq("Password error"));
    }


    @Test
    public void reposForUserWithNoError(){
        // Given
        List<UserResponse> users = new LinkedList<>();
        Response<List<UserResponse>> responseMock = Mockito.mock(Response.class);

        UserResponse userMock = new UserResponse();
        userMock.setEmail("mockemail");
        userMock.setPassword("123456789");
        users.add(0,userMock);


        Mockito.when(responseMock.body()).thenReturn(users);
        Call<List<UserResponse>> callMock = Mockito.mock(Call.class);
        Mockito.when(mlogInServiceMock.reposForUser(anyString())).thenReturn(callMock);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Callback callback = invocation.getArgument(0);
                callback.onResponse(callMock, responseMock);
                return null;
            }
        }).when(callMock).enqueue(any(Callback.class));

        // When
        logInPresenter.doLogin("mockemail", "123456789");

        // Then
        Mockito.verify(mLoginViewMock).onLoginFinished();
    }
}
