package br.com.alura.aluraviagens.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ResourceUtil {
    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDrawble = resources.getIdentifier(drawableEmTexto, "drawable", context.getPackageName());
        return resources.getDrawable(idDrawble);
    }

}
