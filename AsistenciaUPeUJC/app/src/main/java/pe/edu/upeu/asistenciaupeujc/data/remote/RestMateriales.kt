package pe.edu.upeu.asistenciaupeujc.data.remote

import pe.edu.upeu.asistenciaupeujc.modelo.Materiales
import pe.edu.upeu.asistenciaupeujc.modelo.MaterialesReport
import pe.edu.upeu.asistenciaupeujc.modelo.MsgGeneric
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface RestMateriales {
    @GET("/asis/materiales/list")
    suspend fun reportarMateriales(@Header("Authorization") token:String):Response<List<Materiales>>


    @GET("/asis/materiales/buscar/{id}")
    suspend fun getMaterialesId(@Header("Authorization") token:String , @Query("id") id:Long):Response<Materiales>


    @DELETE("/asis/materiales/eliminar/{id}")
    suspend fun deleteMateriales(@Header("Authorization") token:String , @Path("id") id:Long):Response<MsgGeneric>


    @PUT("/asis/materiales/editar/{id}")
    suspend fun actualizarMateriales(@Header("Authorization") token:String , @Path("id") id:Long , @Body materiales :Materiales):Response<Materiales>

    @POST("/asis/materiales/crear")
    suspend fun insertarMateriales(@Header("Authorization") token:String , @Body materiales :Materiales):Response<Materiales>


}