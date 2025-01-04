import java.util.*;

class Task {
    int userId;
    int taskId;
    int priority;

    public Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }
}

class TaskManager {
    private Map<Integer, Task> taskMap;
    private TreeSet<Task> taskSet;

    public TaskManager(List<List<Integer>> tasks) {
        taskMap = new HashMap<>();
        taskSet = new TreeSet<>((a, b) -> 
            a.priority != b.priority ? b.priority - a.priority : b.taskId - a.taskId
        );

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        taskSet.add(task);
    }

    public void edit(int taskId, int newPriority) {
        if (taskMap.containsKey(taskId)) {
            Task task = taskMap.get(taskId);
            taskSet.remove(task); // Efficient removal from TreeSet
            task.priority = newPriority; // Update priority
            taskSet.add(task); // Reinsert with updated priority
        }
    }

    public void rmv(int taskId) {
        if (taskMap.containsKey(taskId)) {
            Task task = taskMap.get(taskId);
            taskSet.remove(task); // Efficient removal
            taskMap.remove(taskId);
        }
    }

    public int execTop() {
        if (!taskSet.isEmpty()) {
            Task topTask = taskSet.first(); // Retrieve the top-priority task
            taskSet.remove(topTask); // Remove from TreeSet
            taskMap.remove(topTask.taskId); // Remove from HashMap
            return topTask.userId;
        }
        return -1; // No tasks available
    }
}
