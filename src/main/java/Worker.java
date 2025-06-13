public class Worker {

    private OnTaskDoneListener onTaskDoneListener; // Переменная интерфейса для реализации метода:

    public Worker(OnTaskDoneListener onTaskDoneListener){
        this.onTaskDoneListener = onTaskDoneListener;
    }
    public void start(){
        for(int i = 0;i<100;i++){
            onTaskDoneListener.onDone("Task " + i + " is done");
        }
    }
}

// Функциональный интерфейс
@FunctionalInterface
interface OnTaskDoneListener{
    void onDone(String result);
}
