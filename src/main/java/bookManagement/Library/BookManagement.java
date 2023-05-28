package bookManagement.Library;

public class BookManagement {
    private LibraryBookManagementStrategy libraryBookManagementStrategy;

    public Library bookStateChange(){
        return libraryBookManagementStrategy.bookStateChange();
    }

    public void setLibraryBookManagementStrategy(LibraryBookManagementStrategy libraryBookManagementStrategy){
        this.libraryBookManagementStrategy = libraryBookManagementStrategy;
    }
}
