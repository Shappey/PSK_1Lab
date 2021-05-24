package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Computer;
import lt.vu.persistence.ComputerDAO;
import lt.vu.rest.collectionDTO.ComputerDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ApplicationScoped
@Path("/computers")
public class ComputerController {

    @Inject
    @Getter @Setter
    private ComputerDAO computerDAO;

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") final Integer id){
        Computer computer = computerDAO.findOne(id);
        if (computer == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ComputerDTO computerDTO = new ComputerDTO();
        computerDTO.setName(computer.getName());
        if(computer.getBuildDate() != null) {
            computerDTO.setBuildDate(computer.getBuildDate().toString());
        }
        if(computer.getWarrantyEnd() != null){
            computerDTO.setWarrantyEnd(computer.getWarrantyEnd().toString());
        }

        return Response.ok(computerDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer computerId, ComputerDTO computerDTO, @QueryParam("ole")final Boolean invokeOLE){ //RENAME INVOKE IR OLE
        try{
            Computer oldComputer = computerDAO.findOne(computerId);
            if(oldComputer == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            oldComputer.setName(computerDTO.getName());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            oldComputer.setBuildDate(format.parse(computerDTO.getBuildDate()));
            oldComputer.setWarrantyEnd(format.parse(computerDTO.getWarrantyEnd()));

            computerDAO.update(oldComputer);
            if(invokeOLE != null && invokeOLE){
                computerDAO.flush();
                computerDAO.persist(oldComputer);
            }
            return Response.ok().build();
        }catch (OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }catch (ParseException e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ComputerDTO computerDTO){
        try {
            Computer computerToCreate = new Computer();
            computerToCreate.setName(computerDTO.getName());
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            computerToCreate.setBuildDate(format.parse(computerDTO.getBuildDate()));
            computerToCreate.setWarrantyEnd(format.parse(computerDTO.getWarrantyEnd()));

            computerDAO.persist(computerToCreate);
            return Response.ok().build();
        } catch (OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        } catch (ParseException pe) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}