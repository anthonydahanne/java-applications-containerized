FROM anthonydahanne/stack-base-debian:10

# Set required CNB information
ARG stack_id
LABEL io.buildpacks.stack.id="${stack_id}"

# Set user and group (as declared in base image)
USER ${CNB_USER_ID}:${CNB_GROUP_ID}