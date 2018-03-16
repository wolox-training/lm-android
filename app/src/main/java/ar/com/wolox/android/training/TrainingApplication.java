package ar.com.wolox.android.training;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;

import ar.com.wolox.wolmo.networking.retrofit.NetworkingApplication;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;

public class TrainingApplication extends NetworkingApplication {

    @Override
    public RetrofitServices getRetrofitServices() {
        return new TrainingRetrofitServices();
    }

    @Override
    public void onInit() {
        Fresco.initialize(this);
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
