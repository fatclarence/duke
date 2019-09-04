package duke.task;

import duke.exception.DukeException;

import java.util.ArrayList;

/**
 * Represents the list of completed and uncompleted tasks.
 */
public class TaskList {

    /**
     * Represents the list of tasks.
     */
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> loadedTasks) {
        this.tasks = loadedTasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * This method adds the <code>task</code> into the task list.
     *
     * @param task The task to be added.
     */
    public void add(Task task) {
        this.tasks.add(task);
    }

    /**
     * This method removes the <code>task</code> from the task list.
     *
     * @param index The zero-based index of the task to be deleted.
     * @return The task that was removed in a string format.
     * @throws DukeException If there is a problem with data processing, loading or saving.
     */
    public String delete(int index) throws DukeException {
        try {
            return this.tasks.remove(index).toString();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Something went wrong: " + e.getMessage());
        }
    }

    public int size() {
        return this.tasks.size();
    }

    public Task get(int index) {
        return this.tasks.get(index);
    }

    /**
     * This method marks the specified task in the task list as done.
     *
     * @param taskNumber The task to be marked as done.
     */
    public void markAsDone(int taskNumber) {
        this.tasks.get(taskNumber).markedAsDone();
    }

    /**
     * This method retrieves all the task from the task list.
     *
     * @return The task lists.
     */
    public ArrayList<Task> getAllTasks() {
        return this.tasks;
    }

    /**
     * This method when called will go through <code>tasks</code>
     * to find <code>Task</code> with the keyword specified <code>word</code>.
     *
     * @param word Keyword to search.
     * @return ArrayList of tasks.
     */
    public ArrayList<Task> findTaskWithWord(String word) {
        ArrayList<Task> tasksWithWord = new ArrayList<>();
        int numberOfTask = this.tasks.size();
        for (int i = 0; i < numberOfTask; i++) {
            Task task = this.tasks.get(i);
            if (task.getDescription().contains(word)) {
                tasksWithWord.add(task);
            }
        }
        return tasksWithWord;
    }
}