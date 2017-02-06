package za.co.entelect.jbootcamp.utils;

import org.springframework.data.domain.Page;
import org.springframework.web.servlet.ModelAndView;

public class Paging {
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = { 5, 10, 20 };

    public Integer initialPageSize(Integer pageSize) {
        // Evaluate page size. If requested parameter is null, return initial
        // page size
        return pageSize == null ? INITIAL_PAGE_SIZE : pageSize;
    }

    public Integer initialPage(Integer page) {
        // Evaluate page. If requested parameter is null or less than 0 (to
        // prevent exception), return initial size. Otherwise, return value of
        // param. decreased by 1.
        return (page == null || page < 1) ? INITIAL_PAGE : page - 1;
    }

    public <T> ModelAndView getModelAndView(String viewName, Page<T> collection, Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView(viewName);

        Pager pager = new Pager(collection.getTotalPages(), collection.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("collection", collection);
        modelAndView.addObject("selectedPageSize", pageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        return modelAndView;
    }

}
