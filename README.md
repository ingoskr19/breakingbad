Breaking Bad characters test implementation

###### Project architecture  ######

Clean architecture:
  - ViewModel
  - RxJava
  - Retrofit
  - Room Database
  - Dagger2 

Directories structure:
  - base (For base clases)
  - config (Constants class)
  - di (Dagger configuration, scopes, AppModule, AppComponent )
  - presentation (Common classes for States and Data Handling between UI and ViewModel)
  - screens (Bussines Modules)
    - characters
      - data (Database layer, Entity, Dao, Repository, Api)
      - domain (Use cases/Interactor layer)
      - module (Provide modules for dagger)
      - presentation (UI presentation layer)
        - model (dto)
        - view
          - adapter
          - fragment
          - listener
          - activity
        - viewmodel
  
