package com.example.trainingdata.security;

import com.example.trainingdata.exception.InvalidTrainerIdException;
import com.example.trainingdata.repository.TrainerRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class XUserIdFilter extends OncePerRequestFilter {

    private final TrainerRepository trainerRepository;

    public XUserIdFilter(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        var trainerId = request.getHeader("X-User-Id");

        if (trainerId == null) {
            chain.doFilter(request, response);
        }

        this.trainerRepository.findById(Long.parseLong(
                                Objects
                                        .requireNonNull(trainerId)
                        )
                )
                .ifPresentOrElse(trainer -> SecurityContextHolder
                        .getContext()
                        .setAuthentication(
                                new UsernamePasswordAuthenticationToken(
                                        trainer,
                                        null,
                                        new ArrayList<>()
                                )
                        ), () -> {
                    throw new InvalidTrainerIdException();
                });

        chain.doFilter(request, response);
    }
}
