package de.lebaasti.waterfallmanager.functions

import net.luckperms.api.LuckPermsProvider
import net.luckperms.api.model.group.Group
import net.luckperms.api.model.user.User

val luckPerms = LuckPermsProvider.get()

val groups = luckPerms.groupManager.loadedGroups.sortedBy { it.weight.orElse(-1) }

var User.group: Group?
    get() = luckPerms.groupManager.getGroup(primaryGroup)
    set(value) {
        this.primaryGroup = (value?.name ?: return)
        luckPerms.userManager.saveUser(this)
    }

val Group.prefix: String?
    get() = cachedData.metaData.prefix

val Group.capitalizedName: String
    get() = name.capitalize()
