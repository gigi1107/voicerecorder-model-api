package com.voicerecorder.helpers;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.IOException;

public class FileAdapter extends TypeAdapter<File> {

    @Override
    public void write(JsonWriter jsonWriter, File file) throws IOException {
        if (file == null) {
            jsonWriter.nullValue();
            return;
        } else {
            file.getPath();
        }
        jsonWriter.value(file.getPath());
    }

    @Override
    public File read(JsonReader jsonReader) throws IOException {
        String path = jsonReader.nextString();
        return new File(path);
    }
}
