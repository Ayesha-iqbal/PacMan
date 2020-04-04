package Tournament;
public abstract class Model extends Bean {

    private String fileName;
    private boolean unsavedChanges;

    public String getFileName(){

        return this.fileName;

    }

    public boolean getUnsavedChanges(){

        return this.unsavedChanges;

    }

    public void setFileName(String fileName){

        this.fileName = fileName;

    }

    public void setUnsavedChanges(Boolean unsavedChanges){

        this.unsavedChanges = unsavedChanges;

    }

}
