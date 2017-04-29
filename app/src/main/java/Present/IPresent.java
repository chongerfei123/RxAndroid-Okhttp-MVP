package Present;

import android.graphics.Bitmap;
import android.util.Log;

import modle.IModle;
import modle.IModleImpV1;
import view.IView;

/**
 * Created by zl on 2017/4/24.
 */

public class IPresent extends BasePresenter<IView> {
    IView iView;

    IModle iModle = new IModleImpV1();
    public IPresent(IView iView) {
      this.iView = iView;
    }

    public void fetch(){
        iView.showLoading();
        iModle.loadData(new IModle.OnLoadCompleteListener() {
            @Override
            public void onComplete(Bitmap bitmap) {
                iView.showPic(bitmap);
                iView.hideLoading();
            }
        });
    }
}
