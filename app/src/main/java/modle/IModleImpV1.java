package modle;

import android.graphics.Bitmap;

import http.DownloadImage;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zl on 2017/4/24.
 */

public class IModleImpV1 implements IModle {
    @Override
    public void loadData(final OnLoadCompleteListener listener) {
        DownloadImage downloadImage = DownloadImage.getInstance();
        Observable observable = downloadImage.loadImage();
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bitmap>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Bitmap o) {
                listener.onComplete(o);
            }
        });
    }
}
