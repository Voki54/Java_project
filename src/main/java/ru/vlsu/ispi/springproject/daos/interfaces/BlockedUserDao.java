package ru.vlsu.ispi.springproject.daos.interfaces;

import ru.vlsu.ispi.springproject.models.BlockedUser;

public interface BlockedUserDao {
    BlockedUser addBlockedUser(BlockedUser blockedUser);
    void deleteBlockedUser(BlockedUser blockedUser);
}
