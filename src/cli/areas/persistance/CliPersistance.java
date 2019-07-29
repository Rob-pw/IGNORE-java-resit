public
 class CliPersistance
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   CliValidity isChoiceValid
    ( Application app)
  { return CliValidity.valid(); }

  public
   Choice<CliShow> getCliChoice()
  { return
      new Choice<CliShow>
        ( (CliShow)this
        , "/"
        , "save application to disk"); }

  public
   void show
    (Application app)
  { CliSelector.say("Attempting to save..")

  ; new ApplicationPersist()
      .save(app)

  ; CliSelector.say
     ("Success (Booyah)!"
        + "You can now safely exit."); } }
