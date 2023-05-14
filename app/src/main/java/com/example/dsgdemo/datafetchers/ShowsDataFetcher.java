package com.example.dsgdemo.datafetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import com.example.dsgdemo.data.Show;
import java.util.stream.Collectors;
import java.util.List;


@DgsComponent
public class ShowsDataFetcher {
    private final List<Show> shows = List.of(
					     new Show("Stranger things", 2016),
					     new Show("Ozark", 2017),
					     new Show("The crown", 2018),
					     new Show("Dead to me", 2013)
);
    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
	if(titleFilter == null) {
	    return shows;
	}

	return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }
}
