Breaking Bad characters test implementation

###### Project architecture  ######

Android JetPack:
  - ViewModel(LiveData)
  - Retrofit
  - Room Database
  - Hilt
  - Navigation component
  - Roboelectric(Implementation Test)

- RxJava (For observables between ViewModel and Interactor)

Directories structure:
  - base (For base clases)
  - config (Constants class)
  - di (Hilt-AppModule)
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
  
