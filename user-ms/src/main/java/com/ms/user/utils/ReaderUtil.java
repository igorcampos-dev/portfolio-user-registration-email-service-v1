package com.ms.user.utils;

import lombok.SneakyThrows;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ReaderUtil {

    @SneakyThrows({URISyntaxException.class, IOException.class})
    public static String getContentFile(String filename){
        return new String(
                Files.readAllBytes(
                        Paths.get(
                                Objects.requireNonNull(
                                        ReaderUtil.class.getClassLoader().getResource(filename)
                                ).toURI()
                        )
                )
        );
    }


}
