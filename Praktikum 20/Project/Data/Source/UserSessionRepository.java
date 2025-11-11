package Data.Source;

import Data.Model.User;

public class UserSessionRepository implements SessionRepository<User> {
    @Override
    public void setSession(User user) {
        System.out.println("Sesi pengguna disimpan...");
    }

    @Override
    public User getSession() {
        System.out.println("Mengambil sesi pengguna...");
        return new User();
    }

    @Override
    public void destroySession() {
        System.out.println("Sesi pengguna dihapus...");
    }

    @Override
    public void updateSession(User user) {
        System.out.println("Sesi pengguna diperbarui...");
    }
}
