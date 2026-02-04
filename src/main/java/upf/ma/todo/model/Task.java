package upf.ma.todo.model;

public class Task {
    private Long id;
    private String title;
    private String description;
    private Boolean done = false;

    public Task(){}

    public Task(String title, String description){
        this.title = title;
        this.description = description;
    }

    //getters
    public Long getId() {return id;}
    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public Boolean getDone(){return done;}

    //setters
    public void setId(Long id){this.id = id;}
    public void setTitle(String title){this.title= title;}
    public void setDescription(String description){this.description= description;}
    public void setDone(Boolean done){this.done = done;}

    //toString
    @Override
    public String toString(){
        return "Task{id="+id+", title="+title+", description="+description+", done="+done+'}';
    }





}
