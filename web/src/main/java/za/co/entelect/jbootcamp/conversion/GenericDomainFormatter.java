package za.co.entelect.jbootcamp.conversion;

import org.springframework.format.Formatter;
import za.co.entelect.jbootcamp.domain.GenericDomainModelInterface;
import za.co.entelect.jbootcamp.services.GenericService;
import java.text.ParseException;
import java.util.Locale;

public class GenericDomainFormatter<T extends GenericDomainModelInterface, S extends GenericService<T>> implements Formatter<T> {

    S service;

    public T parse(final String text, final Locale locale) throws ParseException {
        final Integer id = Integer.valueOf(text);
        return this.service.findById(id);
    }

    public String print(final T object, final Locale locale) {
        return (object != null ? Integer.toString(object.getId()) : "");
    }

}
