package xyz.neziw.wallet.managers;

import lombok.Getter;
import xyz.neziw.wallet.objects.WalletUser;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {

    @Getter
    private final Map<UUID, WalletUser> users = new ConcurrentHashMap<>();

    @SuppressWarnings("UnusedReturnValue")
    public WalletUser createUser(UUID uuid) {
        WalletUser user = this.users.get(uuid);
        if (user == null) {
            user = new WalletUser(uuid);
            this.users.put(uuid, user);
        }
        return user;
    }

    public void removeUser(UUID uuid) {
        this.users.remove(uuid);
    }

    public WalletUser getUser(UUID uuid) {
        return this.users.get(uuid);
    }
}