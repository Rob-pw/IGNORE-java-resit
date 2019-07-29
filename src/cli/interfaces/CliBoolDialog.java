public
 class CliBoolDialog
{ public static
   Boolean ask
    (String description)
  { CliSelector.say
      ( description)

  ; CliChoiceDialog<Boolean>
     boolDialog = new CliChoiceDialog<Boolean>()
  ; Boolean choice
     = boolDialog
        . makeNumberedPassingChoice
           ( new Boolean[]
              { true, false })
  ; return choice; } }
