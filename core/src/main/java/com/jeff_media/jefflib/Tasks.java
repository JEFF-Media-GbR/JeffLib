package com.jeff_media.jefflib;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.function.Consumer;

/**
 * Shortcuts to schedule tasks
 */
public final class Tasks {

    /*
    Runnables
     */

    /**
     * Schedules a synced repeating task
     *
     * @see BukkitScheduler#runTaskTimer(org.bukkit.plugin.Plugin, Runnable, long, long)
     */
    public static BukkitTask repeat(final Runnable runnable, final long initialDelay, final long delay) {
        return Bukkit.getScheduler().runTaskTimer(JeffLib.getPlugin(), runnable, initialDelay, delay);
    }

    /**
     * Schedules an async repeating task
     *
     * @see BukkitScheduler#runTaskTimerAsynchronously(Plugin, Runnable, long, long)
     */
    public static BukkitTask repeatAsync(final Runnable runnable, final long initialDelay, final long delay) {
        return Bukkit.getScheduler().runTaskTimerAsynchronously(JeffLib.getPlugin(), runnable, initialDelay, delay);
    }

    /**
     * Schedules a synced task to run next tick
     *
     * @see BukkitScheduler#runTask(Plugin, Runnable)
     */
    public static BukkitTask nextTick(final Runnable runnable) {
        return Bukkit.getScheduler().runTask(JeffLib.getPlugin(), runnable);
    }

    /**
     * Schedules an async task to run next tick
     *
     * @see BukkitScheduler#runTaskAsynchronously(Plugin, Runnable)
     */
    public static BukkitTask nextTickAsync(final Runnable runnable) {
        return Bukkit.getScheduler().runTaskAsynchronously(JeffLib.getPlugin(), runnable);
    }

    /**
     * Schedules a synced task to run next tick
     *
     * @see #nextTick(Runnable)
     * @see BukkitScheduler#runTask(Plugin, Runnable)
     * @deprecated Ambiguous method name as the task runs on the next, not the same tick. This is the same as {@link #nextTick(Runnable)}
     */
    @Deprecated
    public static BukkitTask sync(final Runnable runnable) {
        return Bukkit.getScheduler().runTask(JeffLib.getPlugin(), runnable);
    }

    /**
     * Schedules an async task to run next tick
     *
     * @see #nextTickAsync(Runnable)
     * @see BukkitScheduler#runTaskAsynchronously(Plugin, Runnable)
     * @deprecated Ambiguous method name as the task runs on the next, not the same tick. This is the same as {@link #nextTickAsync(Runnable)}
     */
    @Deprecated
    public static BukkitTask async(final Runnable runnable) {
        return Bukkit.getScheduler().runTaskAsynchronously(JeffLib.getPlugin(), runnable);
    }

    /**
     * Schedules a synced task to run at the given delay (in ticks)
     *
     * @see BukkitScheduler#runTaskLater(Plugin, Runnable, long)
     */
    public static BukkitTask later(final Runnable runnable, final long delay) {
        return Bukkit.getScheduler().runTaskLater(JeffLib.getPlugin(), runnable, delay);
    }

    /**
     * Schedules an async task to run at the given delay (in ticks)
     *
     * @see BukkitScheduler#runTaskLaterAsynchronously(Plugin, Runnable, long)
     */
    public static BukkitTask laterAsync(final Runnable runnable, final long delay) {
        return Bukkit.getScheduler().runTaskLaterAsynchronously(JeffLib.getPlugin(), runnable, delay);
    }


     /*
    Consumer<BukkitTask>s
     */

    /**
     * Schedules a synced repeating task
     *
     * @see BukkitScheduler#runTaskTimer(Plugin, Consumer, long, long)
     */
    public static void repeat(final Consumer<BukkitTask> task, final long initialDelay, final long delay) {
        Bukkit.getScheduler().runTaskTimer(JeffLib.getPlugin(), task, initialDelay, delay);
    }

    /**
     * Schedules an async repeating task
     *
     * @see BukkitScheduler#runTaskTimerAsynchronously(Plugin, Consumer, long, long)
     */
    public static void repeatAsync(final Consumer<BukkitTask> task, final long initialDelay, final long delay) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(JeffLib.getPlugin(), task, initialDelay, delay);
    }

    /**
     * Schedules a synced task to run next tick
     *
     * @see BukkitScheduler#runTask(Plugin, Consumer)
     */
    public static void nextTick(final Consumer<BukkitTask> task) {
        Bukkit.getScheduler().runTask(JeffLib.getPlugin(), task);
    }

    /**
     * Schedules an async task to run next tick
     *
     * @see BukkitScheduler#runTaskAsynchronously(Plugin, Consumer)
     */
    public static void nextTickAsync(final Consumer<BukkitTask> task) {
        Bukkit.getScheduler().runTaskAsynchronously(JeffLib.getPlugin(), task);
    }

    /**
     * Schedules a synced task to run next tick
     *
     * @see #nextTick(Consumer)
     * @see BukkitScheduler#runTask(Plugin, Consumer)
     * @deprecated Ambiguous method name as the task runs on the next, not the same tick. This is the same as {@link #nextTick(Consumer)}
     */
    @Deprecated
    public static void sync(final Consumer<BukkitTask> task) {
        Bukkit.getScheduler().runTask(JeffLib.getPlugin(), task);
    }

    /**
     * Schedules an async task to run next tick
     *
     * @see #nextTickAsync(Consumer)
     * @see BukkitScheduler#runTaskAsynchronously(Plugin, Consumer)
     * @deprecated Ambiguous method name as the task runs on the next, not the same tick. This is the same as {@link #nextTickAsync(Consumer)}
     */
    @Deprecated
    public static void async(final Consumer<BukkitTask> task) {
        Bukkit.getScheduler().runTaskAsynchronously(JeffLib.getPlugin(), task);
    }

    /**
     * Schedules a synced task to run at the given delay (in ticks)
     *
     * @see BukkitScheduler#runTaskLater(Plugin, Consumer, long)
     */
    public static void later(final Consumer<BukkitTask> task, final long delay) {
        Bukkit.getScheduler().runTaskLater(JeffLib.getPlugin(), task, delay);
    }

    /**
     * Schedules an async task to run at the given delay (in ticks)
     *
     * @see BukkitScheduler#runTaskLaterAsynchronously(Plugin, Consumer, long)
     */
    public static void laterAsync(final Consumer<BukkitTask> task, final long delay) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(JeffLib.getPlugin(), task, delay);
    }

}
