package hr.fer.seekfit.socialmanagement.domain.api.query.friendship;

import lombok.Builder;

@Builder
public record GetUserFriendsQuery(String userId) {
}
