package view;

import android.graphics.Bitmap;

/**
 * Created by zl on 2017/4/24.
 */

public interface IView {
    void showPic(Bitmap bitmap);
    void showLoading();
    void hideLoading();
}
