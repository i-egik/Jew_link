import java.time.LocalDateTime;
import java.util.function.Function;

public interface ShortURL {
    final class UrlInformation {
        public static Object shortURL;
        final String originalURL;
        private final LocalDateTime ttlTime;
        private Function<UrlInformation, Boolean> remove;
        private int ttlCount;

        public UrlInformation(String shortURL, String originalURL) {
            this.shortURL = shortURL;
            this.originalURL = originalURL;
            this.ttlTime = LocalDateTime.now().plusMinutes(1); //по умолчанию время жизни 1 минута
            this.ttlCount = 3; // по умолчанию 3 перехода по ссылке
            this.remove = remove;
        }

        public boolean isExpired() {
            return LocalDateTime.now().isAfter(ttlTime) || ttlCount <= 0;
        }

        public boolean remove() {
            return remove.apply(UrlInformation.this);
        }

        public void incriment() {
            ttlCount++;
        }
    }
}
