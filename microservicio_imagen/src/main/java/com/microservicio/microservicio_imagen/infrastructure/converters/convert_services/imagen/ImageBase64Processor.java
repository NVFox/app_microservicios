package com.microservicio.microservicio_imagen.infrastructure.converters.convert_services.imagen;

import net.iharder.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageBase64Processor implements IImageProcessor<String, MultipartFile> {

    @Override
    public String getImage(MultipartFile file) throws IOException {
        return Base64.encodeBytes(file != null ? file.getBytes() : null);
    }

}
