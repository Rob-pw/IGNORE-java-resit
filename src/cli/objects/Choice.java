public
 class Choice
  <T>
{ public final T target
; public final String activatedBy
; public final String description;

  public
   Choice
    ( T target
    , String activatedBy
    , String description)
  { this.target = target
  ; this.activatedBy = activatedBy
  ; this.description = description; } }
