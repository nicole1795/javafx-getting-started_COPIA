package org.openjfx;




    public MyHeader(){
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("my_header.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try{
        fxmlLoader.load();
        }catch(IOException exception){
        throw new RuntimeException(exception);
        }
