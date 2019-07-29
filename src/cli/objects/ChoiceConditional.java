public
 class ChoiceConditional<T>
 extends Choice<T>
{ public final CliValidity validity;

  public
   ChoiceConditional
    ( Choice<T> choice
    , CliValidity validity)
  { super
      ( choice.target
      , choice.activatedBy
      , choice.description)

  ; this.validity = validity; } }
