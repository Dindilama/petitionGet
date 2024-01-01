public class ScholarAuthorController {
    private ScholarAuthorModel model;
    private ScholarAuthorView view;

    public ScholarAuthorController(ScholarAuthorModel model, ScholarAuthorView view) {
        this.model = model;
        this.view = view;
    }

    public void fetchAuthorData() {
        model.fetchData();
        view.displayAuthorData(model.getAuthorName(), model.getAuthorId());
    }
}
