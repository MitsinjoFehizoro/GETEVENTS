package app.getevents.models

data class ConferencesResponse(val data : List<Conference>)

data class ConferenceResponse(val data : Conference)

data class ConcoursProjetsResponse(val data : List<ConcoursProjet>)

data class ConcoursProjetResponse(val data : ConcoursProjet)

data class MiniProjetResponse(val data: MiniProjet)

data class ExcursionsResponse(val data : List<Excursion>)

data class ExcursionResponse(val data: Excursion)

data class ReceptionsResponse(val data : List<Reception>)

data class ReceptionResponse(val data : Reception)

data class UserResponse(val data : User)

