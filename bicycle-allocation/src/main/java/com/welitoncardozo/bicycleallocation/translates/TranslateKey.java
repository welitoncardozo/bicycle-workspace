package com.welitoncardozo.bicycleallocation.translates;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.welitoncardozo.bicycleallocation.translates.Translate.BASE_NAME_MESSAGES;
import static com.welitoncardozo.bicycleallocation.translates.Translate.DELIMITER_KEY;
import static java.util.Arrays.stream;
import static java.util.ResourceBundle.getBundle;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.SPACE;

@Slf4j
public class TranslateKey {
    public static String getTranslateMultiple(final String keys) {
        final String[] keysDelimited = keys.split(DELIMITER_KEY.getValue());
        final List<String> keysList = stream(keysDelimited)
                .map(TranslateKey::getTranslateMultipleWords)
                .toList();

        return String.join(DELIMITER_KEY.getValue(), keysList);
    }

    private static String getTranslateMultipleWords(final String word) {
        final String[] wordsDelimited = word.split(SPACE);
        final List<String> keysList = stream(wordsDelimited)
                .map(TranslateKey::getTranslate)
                .toList();

        return String.join(SPACE, keysList);
    }

    public static String getTranslate(final Object key) {
        return getTranslate(key, LocaleContextHolder.getLocale());
    }

    public static String getTranslate(final Object key, final Locale locale) {
        final ResourceBundle resourceBundle = getBundle(BASE_NAME_MESSAGES.getValue(), locale);
        final String keyAsString = Objects.toString(key, EMPTY);

        try {
            return resourceBundle.getString(keyAsString.trim());
        } catch (MissingResourceException e) {
            return keyAsString;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return keyAsString;
        }
    }
}
