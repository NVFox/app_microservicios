package com.microservicio.microservicio_imagen.infrastructure.converters.convert_services.imagen;

import java.io.IOException;

public interface IImageProcessor<T, S> {

    T getImage(S file) throws IOException;

}