package com.example.SDIApp.Service;

import com.example.SDIApp.Repositoriy.WorkerRepository;
import com.example.SDIApp.Model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class WorkerService {
    private final WorkerRepository inMemoryRepo;

    public WorkerService(WorkerRepository inMemoryRepo) {
        this.inMemoryRepo = inMemoryRepo;
    }

    /*
    @Autowired
    public WorkerService (@Qualifier ("w") WorkerRepository inMemoryRepo) {
        this.inMemoryRepo = inMemoryRepo;
        this.inMemoryRepo.populate();
    }
     */

    public Worker addService(Worker new_worker)
    {
        return inMemoryRepo.save(new_worker);
    }

    public List<Worker> addWorkersListService(List<Worker> workers)
    {
        return inMemoryRepo.saveAll(workers);
    }

    public List<Worker> getWorkersService()
    {
        return inMemoryRepo.findAll();
    }

    public Optional<Worker> getService(Integer id)
    {
        return inMemoryRepo.findById(id);
    }

    public void deleteService(Integer id)
    {
        inMemoryRepo.deleteById(id);
    }

    public Worker updateService(Integer id, Worker worker)
    {
        Worker w = inMemoryRepo.findById(id).orElse(null);
        if(w != null)
        {
            w.setFirstName(worker.getFirstName());
            w.setLastName(worker.getLastName());
            w.setAge(worker.getAge());
            w.setEmail(worker.getEmail());
            w.setGender(worker.getGender());
            w.setSalary(worker.getSalary());
            return inMemoryRepo.save(w);
        }
        return null;
    }

    // this function returns all workers with a salary higher than 'givenSalary'
    public List<Worker> filterService(int givenSalary)
    {
        Iterable<Worker> allWorkers = inMemoryRepo.findAll(); // get the workers from the database as an Iterable

        // then we'll convert the Iterable to a List of objects
                // this is done by transforming the Iterable<Worker> into Stream<Worker> with the help of StreamSupport
                // firstly, the Iterable is transformed into Spliterator<Worker> with allWorkers.spliterator()
                // the false parameter indicates that the list is not parallel
                        // we want a sequential stream that will process its elements in a single thread
                // then the result is passed to a stream ( Worker<Stream> )
                // the result is then collected into a List<Worker>, which is what we need
        // the function returns a List<Worker> variable
        return StreamSupport.stream(allWorkers.spliterator(), false)
                .filter(worker -> worker.getSalary() > givenSalary)
                .collect(Collectors.toList());
    }
}
