package ar.com.wolox.android.training.ui.login;
import static org.assertj.core.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Matchers.eq;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import ar.com.wolox.android.training.ui.network.services.LogInService;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;


public class LogInPresenterTest {

    RetrofitServices retrofitServicesMock;
    LogInService logInServiceMock;
    LogInPresenter logInPresenter;

    @Before
    public void beforeTest(){
        retrofitServicesMock = Mockito.mock(RetrofitServices.class);
        logInServiceMock = Mockito.mock(LogInService.class);
        Mockito.doReturn(logInServiceMock).when(retrofitServicesMock).getService(eq(LogInService.class));
        //Mockito.when(retrofitServicesMock.getService(eq(LogInService.class))).thenReturn(logInServiceMock);
        logInPresenter = new LogInPresenter(null, retrofitServicesMock);
    }

    @Test
    public void sarasa(){
        logInPresenter.doLogin("sadsad", "afrafea");
        assertThat(4).isLessThan(3);}

}
