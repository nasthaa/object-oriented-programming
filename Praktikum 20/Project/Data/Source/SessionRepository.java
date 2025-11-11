package Data.Source;

public interface SessionRepository<T> {
    public static final String SHARED_PREFERENCE_NAME = "APP_SESSION";

    void setSession(T t);

    T getSession();

    void destroySession();
    
    void updateSession(T t);
}
