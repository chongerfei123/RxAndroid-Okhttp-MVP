package modle;

import android.graphics.Bitmap;

/**
 * Created by zl on 2017/4/24.
 */

public interface IModle {

    void loadData(OnLoadCompleteListener listener);

    interface OnLoadCompleteListener{
        void onComplete(Bitmap bitmap);
    }
}
