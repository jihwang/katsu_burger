package services;

import com.katsuburger.webapp.repository.ItemRepository;
import com.katsuburger.webapp.repository.LocationRepository;
import com.katsuburger.webapp.repository.MenuCategoryRepository;
import com.katsuburger.webapp.repository.MenuItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationService {
    private LocationRepository locationRepository;
    private MenuCategoryRepository menuCategoryRepository;
    private MenuItemRepository menuItemRepository;
    private ItemRepository itemRepository;


}
