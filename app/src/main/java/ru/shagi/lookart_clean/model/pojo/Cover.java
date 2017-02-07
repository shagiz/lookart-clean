package ru.shagi.lookart_clean.model.pojo;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import ru.shagi.lookart_clean.model.AutoGson;

@AutoValue
@AutoGson
public abstract class Cover implements Parcelable {

    public static Cover create(String big, String small) {
        return new AutoValue_Cover(big, small);
    }

    public static TypeAdapter<Cover> typeAdapter(Gson gson) {
        return new AutoValue_Cover.GsonTypeAdapter(gson);
    }

    public abstract String big();

    public abstract String small();
}
