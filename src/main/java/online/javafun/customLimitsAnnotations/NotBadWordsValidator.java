package online.javafun.customLimitsAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

class NotBadWordsValidator implements ConstraintValidator<NotBadWords, String> {
    private Lang[] languages;

    @Override
    public void initialize(NotBadWords constraintAnnotation) {
        this.languages = constraintAnnotation.lang();
    }

    @Override
    public boolean isValid(String text, ConstraintValidatorContext constraintValidatorContext) {
        for (Lang lang : languages) {
            if (isContainBadWords(text, lang.getBadWords())) {
                return false;
            }
        }
        return true;
    }

    private boolean isContainBadWords(String text, String[] badWords) {
        String lowerCasedText = text.toLowerCase();
        return Arrays.stream(badWords)
                .anyMatch(lowerCasedText::contains);
    }
}
