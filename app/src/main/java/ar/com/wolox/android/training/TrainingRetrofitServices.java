package ar.com.wolox.android.training;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.readystatesoftware.chuck.ChuckInterceptor;

import org.joda.time.DateTime;

import ar.com.wolox.android.training.ui.network.Serializer.DateTimeDeserializer;
import ar.com.wolox.wolmo.networking.BuildConfig;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class TrainingRetrofitServices extends RetrofitServices {

    @NonNull
    @Override
    public String getApiEndpoint() {
        return Configuration.API_ENDPOINT;
    }

    @Override
    protected void initClient(@NonNull OkHttpClient.Builder builder) {

        // Only add logs in debug versions (not production ones)
        if (BuildConfig.DEBUG) {

            // Add Logcat HTTP requests logging
            HttpLoggingInterceptor loggerInterceptor = new HttpLoggingInterceptor();
            loggerInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggerInterceptor);

            // Add Chuck interceptor to log HTTP request in a notification
            builder.addInterceptor(new ChuckInterceptor(TrainingApplication.getInstance()));
        }
    }

    @Override
    protected void initGson(@NonNull GsonBuilder builder) {
        builder.registerTypeAdapter(DateTime.class, new DateTimeDeserializer());
    }
}
