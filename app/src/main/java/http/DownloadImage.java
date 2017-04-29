package http;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import url.AllURL;

/**
 * Created by zl on 2017/4/24.
 */

public class DownloadImage {
    private OkHttpClient client;
    private static DownloadImage downloadImage;

    public DownloadImage() {
        client = new OkHttpClient();
    }

    public static DownloadImage getInstance(){
        if (downloadImage == null){
            synchronized (DownloadImage.class){
                downloadImage = new DownloadImage();
            }
        }
        return downloadImage;
    }

    public Observable loadImage(){
        Observable<Bitmap> observable = Observable.create(new Observable.OnSubscribe<Bitmap>() {
            @Override
            public void call(final Subscriber<? super Bitmap> subscriber) {
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(AllURL.lmageUrl).build();
                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        byte[] bytes = response.body().bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        subscriber.onNext(bitmap);
                        subscriber.onCompleted();
                    }
                });
            }
        });
        return observable;
    }
}
