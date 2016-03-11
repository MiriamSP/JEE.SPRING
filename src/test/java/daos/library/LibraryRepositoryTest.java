package daos.library;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestPersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestPersistenceConfig.class})
public class LibraryRepositoryTest {
    
    @Autowired
    private LibraryRepository libraryRepository;
    
    @Autowired
    private BookDao bookDao;
    
    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testPopulate() {
        libraryRepository.populate();
        assertTrue(3 == bookDao.count());
        assertTrue(4 == authorDao.count());
    }

    @Test
    public void testDeleteAll() {
        libraryRepository.deleteAll();
    }

}
