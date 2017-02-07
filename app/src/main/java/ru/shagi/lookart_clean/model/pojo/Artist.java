package ru.shagi.lookart_clean.model.pojo;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

import ru.shagi.lookart_clean.model.AutoGson;

@AutoValue
@AutoGson
public abstract class Artist implements Parcelable {

    public static Artist create(String id,
                                Cover cover,
                                List<String> genres,
                                String description,
                                String link,
                                String albums,
                                String name,
                                String tracks) {
        return new AutoValue_Artist(id, cover, genres, description, link, albums, name, tracks);
    }

    public static TypeAdapter<Artist> typeAdapter(Gson gson) {
        return new AutoValue_Artist.GsonTypeAdapter(gson);
    }

    public abstract String id();

    public abstract Cover cover();

    public abstract List<String> genres();

    public abstract String description();

    public abstract String link();

    public abstract String albums();

    public abstract String name();

    public abstract String tracks();
}
