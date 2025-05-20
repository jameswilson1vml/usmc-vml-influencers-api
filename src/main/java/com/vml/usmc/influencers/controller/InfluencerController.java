package com.vml.usmc.influencers.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vml.usmc.influencers.model.Influencer;
import com.vml.usmc.influencers.service.InfluencerService;

import java.net.URI;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/influencers")
@Tag(name = "Influencers", description = "Influencers management APIs")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;

    @Operation(summary = "Get all influencers", description = "Returns a list of all available influencers")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved influencers",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Influencer.class)))
    })
    @GetMapping
    public ResponseEntity<Set<Influencer>> getInfluencers() {
        return ResponseEntity.ok(influencerService.getAllInfluencers());
    }

    @Operation(summary = "Get an influencer", description = "Returns an influencer by id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved an influencer",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Influencer.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencer(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(influencerService.getInfluencerById(id));
    }

    @Operation(summary = "Post an influencer", description = "Adds an influencer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Successfully created an influencer",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Influencer.class)))
    })
    @PostMapping
    public ResponseEntity<Influencer> addInfluencer(@Valid @RequestBody Influencer influencer) {
        UUID id = influencerService.addNewInfluencer(influencer);

        influencer.setId(id);

        return ResponseEntity.created(URI.create("/influencers/" + id.toString()))
            .body(influencer);
    }

    @Operation(summary = "Post an influencer", description = "Adds an influencer")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Successfully updated an influencer",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Influencer.class)))
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Influencer> updateInfluencer(@PathVariable("id") UUID id, @Valid @RequestBody Influencer influencer) {
        influencer.setId(id);

        influencerService.updateInfluencer(influencer);

        return ResponseEntity.noContent().build();
    }
}
