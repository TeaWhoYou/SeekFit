package hr.fer.seekfit.socialmanagement.rest.controler.api;

import static hr.fer.seekfit.socialmanagement.rest.Constants.ACCEPTED;
import static hr.fer.seekfit.socialmanagement.rest.Constants.BAD_REQUEST;
import static hr.fer.seekfit.socialmanagement.rest.Constants.OK;
import static hr.fer.seekfit.socialmanagement.rest.Constants.SERVER_ERROR;
import static hr.fer.seekfit.socialmanagement.rest.Constants.SERVER_ERROR_MESSAGE;

import hr.fer.seekfit.socialmanagement.rest.dto.ErrorDto;
import hr.fer.seekfit.socialmanagement.rest.dto.friendship.AcceptFriendRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.friendship.FriendshipIdDto;
import hr.fer.seekfit.socialmanagement.rest.dto.friendship.FriendshipResponseDto;
import hr.fer.seekfit.socialmanagement.rest.dto.friendship.IgnoreFriendRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.friendship.RemoveFriendRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.friendship.SendFriendRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.friendship.UserFriendsListDto;
import hr.fer.seekfit.socialmanagement.rest.dto.group.AddGroupMemberRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.group.CancelInviteRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.group.ChangeGroupDetailsRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.group.CreateGroupRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.group.GroupIdDto;
import hr.fer.seekfit.socialmanagement.rest.dto.group.GroupMembersListDto;
import hr.fer.seekfit.socialmanagement.rest.dto.group.GroupResponseDto;
import hr.fer.seekfit.socialmanagement.rest.dto.group.InviteUserRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.group.JoinGroupRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.group.LeaveGroupRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.group.RemoveGroupMemberRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.user.RegisterUserRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.user.RenameUserRequest;
import hr.fer.seekfit.socialmanagement.rest.dto.user.UserIdDto;
import hr.fer.seekfit.socialmanagement.rest.dto.user.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Social Management API", description = "API for managing social interactions")
public interface SocialManagementControllerApiDocks {

    String USER_TAG = "User Management";
    String GROUP_TAG = "Group Management";
    String FRIENDSHIP_TAG = "Friendship Management";

    /**
     * Register a new user.
     */
    @Operation(summary = "Register a new user", tags = USER_TAG, description = "Allows creating a new user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "User registered."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid user data.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    UserIdDto registerUser(
        @RequestBody(description = "DTO for registration of the user.", required = true)
        RegisterUserRequest registerUserRequest);

    /**
     * Rename an existing user.
     */
    @Operation(summary = "Rename user", tags = USER_TAG, description = "Allows renaming an existing user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "User renamed."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid rename request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    UserIdDto renameUser(
        @RequestBody(description = "DTO for renaming a user.", required = true)
        RenameUserRequest renameUserRequest);

    /* ----------------- Group Endpoints ----------------- */
    @Operation(summary = "Create a new group", tags = GROUP_TAG, description = "Allows creating a new group.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "Group created."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid group data.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    GroupIdDto createGroup(
        @RequestBody(description = "DTO for creating a group.", required = true)
        CreateGroupRequest createGroupRequest);

    @Operation(summary = "Change group details", tags = GROUP_TAG, description = "Allows changing group name or description.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "Group details changed."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid change request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    GroupIdDto changeGroupDetails(
        @RequestBody(description = "DTO for changing group details.", required = true)
        ChangeGroupDetailsRequest changeRequest);

    @Operation(summary = "Add a member to a group", tags = GROUP_TAG)
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "Member added."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    GroupIdDto addGroupMember(
        @RequestBody(description = "DTO for adding a member to the group.", required = true)
        AddGroupMemberRequest request);

    @Operation(summary = "Remove a member from a group", tags = GROUP_TAG)
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "Member removed."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    GroupIdDto removeGroupMember(
        @RequestBody(description = "DTO for removing a member from the group.", required = true)
        RemoveGroupMemberRequest request);

    /**
     * Invite a user to a group.
     */
    @Operation(summary = "Invite a user to a group", tags = GROUP_TAG, description = "Invites a user to join the group.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "202", description = "User invited."),
        @ApiResponse(responseCode = "400", description = "Invalid invite request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = "500", description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    void inviteUser(
        @RequestBody(description = "DTO for inviting a user to the group.", required = true)
        InviteUserRequest request);

    /**
     * Cancel a user's invitation to a group.
     */
    @Operation(summary = "Cancel user invitation", tags = GROUP_TAG, description = "Cancels an existing user invitation to the group.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "202", description = "Invitation cancelled."),
        @ApiResponse(responseCode = "400", description = "Invalid cancel invite request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = "500", description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    void cancelInvite(
        @RequestBody(description = "DTO for cancelling a user's invitation.", required = true)
        CancelInviteRequest request);

    /**
     * Join a group via an invitation link.
     */
    @Operation(summary = "Join a group via invitation link", tags = GROUP_TAG, description = "Allows a user to join a group using an invitation link.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "202", description = "User joined the group."),
        @ApiResponse(responseCode = "400", description = "Invalid join request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = "500", description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    void joinGroup(
        @RequestBody(description = "DTO for joining a group via invitation link.", required = true)
        JoinGroupRequest request);

    /**
     * Leave a group.
     */
    @Operation(summary = "Leave a group", tags = GROUP_TAG, description = "Allows a user to leave a group.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "202", description = "User left the group."),
        @ApiResponse(responseCode = "400", description = "Invalid leave request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = "500", description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    void leaveGroup(
        @RequestBody(description = "DTO for leaving a group.", required = true)
        LeaveGroupRequest request);

    /* -------------- Friendship Endpoints -------------- */
    @Operation(summary = "Send a friend request", tags = FRIENDSHIP_TAG, description = "Allows sending a friend request.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "Friend request sent."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    FriendshipIdDto sendFriendRequest(
        @RequestBody(description = "DTO for sending a friend request.", required = true)
        SendFriendRequest request);

    @Operation(summary = "Accept a friend request", tags = FRIENDSHIP_TAG, description = "Allows accepting a pending friend request.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "Friend request accepted."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    FriendshipIdDto acceptFriendRequest(
        @RequestBody(description = "DTO for accepting a friend request.", required = true)
        AcceptFriendRequest request);

    @Operation(summary = "Ignore a friend request", tags = FRIENDSHIP_TAG, description = "Allows ignoring a pending friend request.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "Friend request ignored."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    FriendshipIdDto ignoreFriendRequest(
        @RequestBody(description = "DTO for ignoring a friend request.", required = true)
        IgnoreFriendRequest request);

    @Operation(summary = "Remove friend", tags = FRIENDSHIP_TAG, description = "Allows removing an existing friend connection.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = ACCEPTED, description = "Friend removed."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid request.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))})
    FriendshipIdDto removeFriend(
        @RequestBody(description = "DTO for removing a friend.", required = true)
        RemoveFriendRequest request);

    /* ---------------- Query Endpoints ---------------- */

    @Operation(summary = "Retrieve user by ID", tags = USER_TAG, description = "Fetches user details by their unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = OK, description = "User details retrieved."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid user ID provided.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))
    })
    UserResponseDto getUserById(@PathVariable String userId);

    @Operation(summary = "Retrieve user's friends list", tags = USER_TAG, description = "Fetches the list of friends for a user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = OK, description = "Friends list retrieved."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid user ID provided.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))
    })
    UserFriendsListDto getUserFriends(@PathVariable String userId);

    @Operation(summary = "Retrieve group by ID", tags = GROUP_TAG, description = "Fetches group details by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = OK, description = "Group details retrieved."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid group ID provided.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))
    })
    GroupResponseDto getGroupById(@PathVariable String groupId);

    @Operation(summary = "Retrieve group members", tags = GROUP_TAG, description = "Fetches the list of members for a group.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = OK, description = "Group members retrieved."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid group ID provided.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))
    })
    GroupMembersListDto getGroupMembers(@PathVariable String groupId);

    @Operation(summary = "Retrieve friendship by ID", tags = FRIENDSHIP_TAG, description = "Fetches friendship details by its unique ID.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = OK, description = "Friendship details retrieved."),
        @ApiResponse(responseCode = BAD_REQUEST, description = "Invalid friendship ID provided.",
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class))),
        @ApiResponse(responseCode = SERVER_ERROR, description = SERVER_ERROR_MESSAGE,
            content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = ErrorDto.class)))
    })
    FriendshipResponseDto getFriendshipById(@PathVariable String friendshipId);

}