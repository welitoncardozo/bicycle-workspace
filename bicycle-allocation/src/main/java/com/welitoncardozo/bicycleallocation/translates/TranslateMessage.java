package com.welitoncardozo.bicycleallocation.translates;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

import static com.welitoncardozo.bicycleallocation.translates.Translate.BASE_NAME_MESSAGES;
import static java.util.Objects.isNull;

public class TranslateMessage {
    private static ResourceBundleMessageSource messageSource;

    public static String getMessage(final MessageSourceResolvable message) throws NoSuchMessageException {
        return getMessage(message, LocaleContextHolder.getLocale());
    }

    public static String getMessage(final MessageSourceResolvable message, final Locale locale) throws NoSuchMessageException {
        return getMessageSource().getMessage(message, locale);
    }

    private static MessageSource getMessageSource() {
        if (isNull(messageSource)) {
            messageSource = new ResourceBundleMessageSource();
            messageSource.setBasenames(BASE_NAME_MESSAGES.getValue());
        }

        return messageSource;
    }
}
